package org.ml.blog.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PageVO<T> implements Serializable {
    // 总页数
    private int totalCount;
    // 页面大小
    private int pageCount;
    // 第几页
    private int pageNo;
    // 页面内容
    private List<T> list;

    public static <T> PageVO<T> getPageVO(Page<?> page, List<T> list) {
        PageVO<T> tPageVO = new PageVO<>();
        tPageVO.setPageNo(page.getNumber());
        tPageVO.setTotalCount(page.getTotalPages());
        tPageVO.setPageCount(list.size());
        tPageVO.setList(list);

        return tPageVO;
    }
}
