package com.example.feignserver.demoserver.model;


import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Person implements Serializable {

	private Long id;
	private Date createTime;
	private Date updateTime;
	private String name;
}
