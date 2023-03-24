package org.zerock.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

@SpringBootTest
@Log4j2
public class ServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO boardDTO = BoardDTO.builder()
                .title("sample title ..")
                .content("sample content ..")
                .writer("user02")
                .build();
        boardService.register(boardDTO);
        BoardDTO.builder()
                .title("sample title ..")
                .content("sample content ..")
                .writer("user03")
                .build();
        boardService.register(boardDTO);
        BoardDTO.builder()
                .title("sample title ..")
                .content("sample content ..")
                .writer("user04")
                .build();
        boardService.register(boardDTO);
        boardDTO = BoardDTO.builder()
                .title("sample title ..")
                .content("sample content ..")
                .writer("user05")
                .build();
        boardService.register(boardDTO);
        BoardDTO.builder()
                .title("sample title ..")
                .content("sample content ..")
                .writer("user06")
                .build();
        boardService.register(boardDTO);
        BoardDTO.builder()
                .title("sample title ..")
                .content("sample content ..")
                .writer("user07")
                .build();
        boardService.register(boardDTO);


    }
}
