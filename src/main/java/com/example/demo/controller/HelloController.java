package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// JSON を返す REST コントローラ
@RestController
@RequestMapping("/api")
public class HelloController {

    // エンドポイント: /api/hello
    @GetMapping("/hello")
    public ResponseMessage hello() {
        // JSON データとして返すオブジェクトを作成
        return new ResponseMessage("Hello, World!", 200);
    }

    // レスポンス用のデータクラス
    static class ResponseMessage {
        private String message;
        private int status;

        // コンストラクタ
        public ResponseMessage(String message, int status) {
            this.message = message;
            this.status = status;
        }

        // ゲッターとセッター (必須)
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
