package com.ingen.service;

import com.ingen.entitiy.Request;

public interface RequestServiceInterface {
    Boolean serviceCreateNewRequestOverCharacterLimit(Request RequestToCheck);
}
