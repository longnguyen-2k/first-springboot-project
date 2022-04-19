package com.example.demo.util;

import com.example.demo.services.post.PostServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    public static void log(String result){
        Logger logger
                = Logger.getLogger(
                PostServiceImpl.class.getName());
        logger.log(Level.WARNING, "This is Log " + result);
    }
}
