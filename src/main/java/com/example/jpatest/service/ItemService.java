package com.example.jpatest.service;

import com.example.jpatest.dto.ItemDto;
import com.example.jpatest.entity.Item;
import com.example.jpatest.entity.ItemImg;
import com.example.jpatest.repository.ItemImgRepo;
import com.example.jpatest.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemImgRepo itemImgRepo;

    //상세페이지
    public Item detail(Long id){
        return itemRepo.findById(id).get();
    }


    //전체글 불러오기 20240220-2
    public Page<Item> allList(Pageable pageable){

        return itemRepo.findAllByOrderByIdDesc(pageable);

        /*List<Item> itemList = itemRepo.findAllByOrderByIdDesc(pageable).getContent();*/ //findAll메서드 : 전체를 불러오기한다
        /*if( !itemList.isEmpty()) {
            List<ItemDto> itemDtoList = new ArrayList<>();
            Iterator<Item> it = itemList.iterator();
            while (it.hasNext()) {
                Item temp = it.next();
                itemDtoList.add(ItemDto.of(temp));
            }

            return itemDtoList;
        }
        return null;*/
    }

    // img파일 중복방지
    public void imgUpload(MultipartFile image, ItemDto itemDto){  // MultipartFile 인터페이스로 image를 받아온다 20240220-3, ItemDto itemDto 20240220-5
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int min = now.getMinute();
        int sec = now.getSecond();

        //파일 업로드 절대경로.
        String absPath = new File("/ray").getAbsolutePath()+"/";
        //파일의 새이름
        String newName = "img"+hour+min+sec;
        //확장자 추출
        String ext = "."+image.getOriginalFilename().replaceAll("^.*\\.(.*)$","$1");
        //저장될 폴더 경로
        String path = "img/"+year+"/"+month+"/"+day;
        try{
            File file = new File(absPath+path);
            if( !file.exists()){
                file.mkdirs();
            }
            file = new File(absPath+path+"/"+newName+ext);
            image.transferTo(file); //파일복사 업로드

            //데이터베이스 저장
            Item item = Item.of(itemDto);
            itemRepo.save(item);

            ItemImg itemImg = new ItemImg();
            itemImg.setImgPath(path);
            itemImg.setImgName(newName+ext);
            itemImg.setOriginalName(image.getOriginalFilename());
            itemImg.setItem(item);

            itemImgRepo.save(itemImg);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
