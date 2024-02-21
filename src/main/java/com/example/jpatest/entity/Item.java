package com.example.jpatest.entity;
//20240220-1
import com.example.jpatest.dto.ItemDto;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.ColumnDefault;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Item {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 50) // db의 not null 설정, 문자 50자까지만 허용
    private String itemName;
    @Column
    private String brand;
    @Column
    private String cpu;
    @Column
    private float inch;
    @Column
    private int ram;
    @Column(columnDefinition = "VARCHAR(255) Default '프리도스'") //db 컬럼 기본값 설정, dbeaver에서는 sql에  default '김유신' 과 같이 설정
    private String os;
    @Column
    private int cost;
    @Column
    private LocalDateTime regDate;
    @Column
    private String seller;

    @OneToOne(mappedBy = "item")
    private ItemImg itemImg;

    //20240221-2 상품 수정 적용 - entity객체 수정 itemService.java 연계
    public void updateItem(ItemDto itemDto){
        this.cost = itemDto.getCost();
        this.cpu = itemDto.getCpu();
        this.itemName = itemDto.getItemName();
        this.brand = itemDto.getBrand();
        this.inch = itemDto.getInch();
        this.ram = itemDto.getRam();
        this.os = itemDto.getOs();
    }

    private static ModelMapper modelMapper=new ModelMapper();
    // 반드시 변수이름이 같아야 한다
    public static Item of(ItemDto itemDto){
        itemDto.setRegDate(LocalDateTime.now());
        return modelMapper.map(itemDto, Item.class);
    }
}
