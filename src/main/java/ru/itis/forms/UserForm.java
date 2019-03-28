package ru.itis.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UserForm {
    Long userId;
    String auth;
}
