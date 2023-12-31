package com.kh.mvc.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.mvc.board.entity.Board;

// @Repository // 생략 가능
public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findByWriter(String writer);
}
