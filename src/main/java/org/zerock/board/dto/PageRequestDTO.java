package org.zerock.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    // 페이징 관련 정보(page/size)외에 검색의 종류(type)와 키워드,(keyword)를 추가해서 지정

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;
    
    private String type; // 검색의 종류 t, c, w, tc, tw, twc ...

    private String keyword;

    public String[] getTypes(){
        if (type == null || type.isEmpty()){
            return null;
        }
        return type.split("");
    }

    // 페이징 처리를 위해 사용하는 Pageable 타입 반환하는 기능
    public Pageable getPageable(String...props){
        return PageRequest.of(this.page-1, this.size, Sort.by(props).descending());
    }

    private String link;

    public String getLink(){
        // 검색 조건과 페이징 조건을 문자열로 구성
        if (link==null){
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);

            if (type != null && type.length() > 0){
                builder.append("&type=" + this.type);
            }

            if (keyword != null){
                try {
                    builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
            link = builder.toString();
        }

        return link;
    }

}
