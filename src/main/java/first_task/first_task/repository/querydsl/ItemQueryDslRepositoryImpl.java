package first_task.first_task.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import first_task.first_task.dto.item.SearchDto;
import first_task.first_task.entity.Item;
import first_task.first_task.entity.QItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemQueryDslRepositoryImpl implements ItemQueryDslRepository {
    private final JPAQueryFactory queryFactory;
    private QItem qItem = QItem.item;
    @Override
    public List<Item> searchAttribute(SearchDto searchDto) {
        return queryFactory.selectFrom(qItem)
                .where(judgeAttribute(searchDto))
                .fetch();
    }

    @Override
    public PageImpl itemPage(Pageable pageable) {
        List<Item> items = queryFactory.selectFrom(qItem)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        Long itemsCounts = queryFactory.select(qItem.count())
                .from(qItem)
                .fetchOne();
        return new PageImpl<>(items, pageable, itemsCounts);
    }

    @Override
    public BooleanBuilder judgeAttribute(SearchDto searchDto) {
        BooleanBuilder builder = new BooleanBuilder();
        if (searchDto.getAttribute() == "name") {
            builder.and(qItem.name.eq(searchDto.getContext()));
        } else if (searchDto.getAttribute() == "price") {
            builder.and(qItem.price.eq(Long.parseLong(searchDto.getContext())));
        } else {
            builder.and(qItem.quantity.eq(Long.parseLong(searchDto.getContext())));
        }
        return builder;
    }
}
