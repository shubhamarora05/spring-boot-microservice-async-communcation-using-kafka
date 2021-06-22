package com.example.dept.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
	private Long departmentId;
	private Long employeeId;
	private MessageDetails messageDetails;
}
