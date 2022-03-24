package site.metacoding.dbtest.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.dbtest.domain.boardTbl.BoardTbl;
import site.metacoding.dbtest.domain.boardTbl.BoardTblRepository;
import site.metacoding.dbtest.web.dto.ResponseDto;

@RestController
public class BoardTblApiController {

    private BoardTblRepository boardTblRepository;

    public BoardTblApiController(BoardTblRepository boardTblRepository) {
        this.boardTblRepository = boardTblRepository;
    }

    @GetMapping("/api/search")
    public ResponseDto<?> search(@RequestParam(defaultValue = "") String keyword) {

        List<BoardTbl> boards = boardTblRepository.mSearch(keyword);

        // return new ResponseDto<List<BoardTbl>>(1, "성공",boards);
        return new ResponseDto<>(1, "성공", boards);
    }
}
