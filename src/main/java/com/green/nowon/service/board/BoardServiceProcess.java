package com.green.nowon.service.board;

import com.green.nowon.domain.dto.board.BoardListDTO;
import com.green.nowon.domain.entity.BoardEntity;
import com.green.nowon.domain.entity.BoardEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BoardServiceProcess implements BoardService{

    //DAO
    @Autowired
    private BoardEntityRepository repository;

    @Override
    public void listAll(Model model) {
        //디비에서 게시글 list
        List<BoardEntity> result = repository.findAll();
        List<BoardListDTO> list = new Vector<>();
        for(BoardEntity e : result){
            int bno = e.getBno();
            String title = e.getTitle();
            int readCount = e.getReadCount();
            String writer = e.getWriter();
            LocalDateTime updatedDate = e.getUpdatedDate();

            BoardListDTO dto = new BoardListDTO();
            dto.setBno(bno);
            dto.setTitle(title);
            dto.setReadCount(readCount);
            dto.setWriter(writer);
            dto.setUpdatedDate(updatedDate);

            list.add(dto);

        }


        model.addAttribute("list",list);  //list.html에서 확인가능
    }

    @Override
    public void getListAll(Model model) {

       // model.addAttribute("list",repository.findAll().stream().map(BoardListDTO::new).collect(Collectors.toList()));
         model.addAttribute("list",repository.myFindAll().stream().map(BoardListDTO::new).collect(Collectors.toList()));

       /* List<BoardEntity> result = repository.findAll();
        Stream<BoardEntity> st =  result.stream();*/
        /*
        Function<BoardEntity, BoardListDTO> mapper = new Function<BoardEntity, BoardListDTO>() {
            @Override
            public BoardListDTO apply(BoardEntity boardEntity) {
                return null;
            }
        };
        */
        //인터페이스 내부에 추상메서드가 딱 1개만있으면(@FunctionalInterface) 생략표현이 가능 ( Lambda 표현식 )
        //Function<BoardEntity, BoardListDTO> mapper = (e) -> { return new BoardListDTO();};
        //{} 내용이 한 줄이면 {} 생략 가능
        //그 한 줄이 return 문장이면 return 키워드도 생략
        //파라미터 개수가 1개이면 ()도 생략 가능 (e) : a
        //Function<BoardEntity, BoardListDTO> mapper = e -> new BoardListDTO(e);

       // Function<BoardEntity, BoardListDTO> mapper = BoardListDTO::new;

       // Stream<BoardListDTO> mappedStream = st.map(mapper);
       // List<BoardListDTO> finalList =  mappedStream.collect(Collectors.toList());
/*
        List<BoardListDTO> result = repository.findAll().stream()
                                    .map(BoardListDTO::new)
                                    .collect(Collectors.toList());

        List<BoardListDTO> aaa= new Vector<>();
        for(BoardEntity e : repository.findAll()){
            BoardListDTO dto = new BoardListDTO(e);
            aaa.add(dto);
        }
        */
    }
}
