package com.example.secondproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.secondproject.domain.BoardDTO;
import com.example.secondproject.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
public class MappersTests {

	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testOfInsert () {
		
				BoardDTO params = new BoardDTO();
				params.setTitle("1번 게시글 제목");
				params.setContent("1번 게시글 내용");
				params.setWriter("테스터");

				int result = boardMapper.insertBoard(params);
				System.out.println("결과는 " + result + "입니다.");
	}
	
	@Test
	public void testOfSelectDetail() {
		BoardDTO board = boardMapper.selectBoardDetail((long) 1);
		try {
			//String boardJson = new ObjectMapper().writeValueAsString(board);
            String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);

			System.out.println("=========================");
			System.out.println(boardJson);
			System.out.println("=========================");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
