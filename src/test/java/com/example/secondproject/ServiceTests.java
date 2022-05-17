package com.example.secondproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.secondproject.domain.BoardDTO;
import com.example.secondproject.mapper.BoardMapper;
import com.example.secondproject.service.BoardServiceImpl;

@SpringBootTest
public class ServiceTests {

	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testByResiterBoard () {
		
		BoardDTO params = new BoardDTO();
		params.setIdx(null);
		params.setTitle("1번게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("1번 게시글 작성자");
		boolean result = boardServiceImpl.registerBoard(params);
		
		System.out.println("==========================");
		System.out.println(result);
		System.out.println("==========================");
	
	}
	
	@Test
	public void testbyGetBoardDetail () {
		
		BoardDTO params = new BoardDTO();
		params.setIdx((long) 115);
		
		System.out.println("==========================");
		System.out.println(boardServiceImpl.getBoardDetail((long) 115));
		System.out.println("==========================");
	
	}
	
	
	@Test
	public void testByDeleteBoard () {
		
		boolean result = boardServiceImpl.deleteBoard((long) 115);
		BoardDTO board = boardMapper.selectBoardDetail((long) 115);
	
		System.out.println("==========================");
		System.out.println(result);
		System.out.println("==========================");
	
	}
	
	@Test
	public void testByGetBoardList () {
		
		int boardTotalCount = 0;
		List<BoardDTO> boardList = boardMapper.selectBoardList();
		
		System.out.println("==========================");
		System.out.println(boardList.toString());
		System.out.println("==========================");
		
	}
	
	
}
