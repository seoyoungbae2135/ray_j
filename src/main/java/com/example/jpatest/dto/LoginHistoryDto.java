package com.example.jpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistoryDto {
    private Long id;
    private Long testMemberEntityId;
    private String ipAddr;
    private LocalDateTime loginDate;
}
