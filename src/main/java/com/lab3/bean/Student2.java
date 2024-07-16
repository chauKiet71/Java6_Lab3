package com.lab3.bean;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {

    @NotBlank(message = "Không để trống email")
    @Email(message = "Không đúng địnhnet dạng email")
    String email;

    @NotBlank(message = "Không để trống họ và tên")
    String fullName;

    @NotNull(message = "Không để trống điểm")
    @PositiveOrZero(message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    Double marks;

    @NotNull(message = "Chưa chọn giới tính")
    Boolean gender;

    @NotBlank(message = "Chưa chọn quốc tịch")
    String country;
}
