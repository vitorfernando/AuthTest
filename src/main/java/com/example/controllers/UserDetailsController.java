/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import org.springframework.stereotype.Controller;

/**
 *
 * @author vitor-s-silva
 */
@Controller
public class UserDetailsController {
    
    public String userDetails(){
        return "userdetails";
    }
    
}
