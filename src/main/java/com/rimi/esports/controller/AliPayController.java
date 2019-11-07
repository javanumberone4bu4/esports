//package com.rimi.esports.controller;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayTradePagePayRequest;
//import com.alipay.api.response.AlipayTradePagePayResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 沙箱支付
// *
// * @author Wang Xiaoping
// * @date 2019/11/7 19:15
// */
//@RestController
//@CrossOrigin
//public class AliPayController {
//
//        public VideoTableService videoTableMapper;
//
//        //@PostMapping("/purchase")
//        @GetMapping("/purchase")
//        public void payment(HttpServletRequest request, HttpServletResponse response, String videoId) throws IOException {
//
//            //生成订单
//            String orderForm =new AcquireOrderForm().getOrderForm();
//            String orderForm1 =new AcquireOrderForm().getOrderForm();
//            AlipayClient alipayClient = new DefaultAlipayClient(
//                    "https://openapi.alipaydev.com/gateway.do",
//                    "2016101600699685",
//                    "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9DqwwbKxNNZfT1+Pn8srveu36cA5WJ3WCAqPRlHnBjzIGbqkKNuKSQ0oHKufEEWur5LlB6MJ8/e+4bPMRvi2Pewa/1iVswdVTuuabpiyR914l9uzmWYsOsokuR1rvYVZqlw3ZBboUXg3z+qpNIy4jwLK9MpDbnHSC3je2rFfP1ahhaxDG7t5ZKp+SenhmzHBoaAt+6evNQxp6tBQAedz+mE+W42fAd535P0GrERqbB01hNbh1q+eKHXELU4yls4GDjROr4yBctPqBVs9d9tl8dLdlt8b/1VXk5PiortcX5GlzgcU8I5TJQLc8hJYcFokEAlRB4luVkc/VrhnTJFLDAgMBAAECggEBAJz6nu0CfzsI4g2LuHhy+CBLUWjePHk7AG44ZO/zufmHPgFrRz7s/cp2xvQWoyUBVgb/vvfEHiGM9MyM4nN8FvaJL7yAQskAVXLVwP/CxkVZQbqCQoiuFzHX+uILa61ShF+zF1N5Vt3sjudj3p54NKqJKaDBaNiBG5lCjL5Icg1mKo7ZlViymxozNUF4z7RGBmxO7SJzgn+UUf44lV9Xsq5jWox6Yu8u8aEjLlWbfsotM5llf69/nbSVoRgKKKYUN8iboHjf8q2K0mDZnd9/RjgnfBbmtAgYGnpCC7mxdHXanFP4t5745c8VpmTr+OrLsxFWHk0ayu3siP7LNSM1lYkCgYEA9TwVfOuPEuOW3lByi2O9Vu9lzaCdeJ2WRwaVIb9FqtiVM4xEbmHu7wa23DaV8lYrLYqpTtkpF+IdtwyGGmRD5HysHxc/Qv5T65lixjYUKgEg3XpSCfFUTLYFzGdQ/3LErXYlbS79v+esdU7ELrnY+TAfN3UEX2eo107BD+YT3b8CgYEAxVtGP+ovFN4rPVL+qEVLLlSauBBNsmTwdp0640Hj8XZgoPv4xR1cDH6HEA+/DeD3Zs+MQJC9NylqbcfbxwTCVOsgHwRK6nHTJ5sUF8pq45JaMkQ9wFYqbMm0o+6erFNJId7S/IdKazcnqdBFojCjkqx2m2BJ8kv0ds0knfUzE/0CgYB2ByL4ao8DslHMUb+vYqOgEbxXiTQA9yd6q6pfAaXQIkk89AeDcNMEa6Dav9LPPbWuR4xRDKeAfS18CiUI0rTyZSaaGCA0aB+PxtUJPMHbrYtZzSNq8aF3AiwsQpVzPJN4QOKmd/VcxW31T6GQM5Y/6G89y639FPDoH1lAA6YQFQKBgQCBWDjKWulQe+tK3cIY9pE3ZCuixsylRpJyqsmVd/G0pyjdWUbJqVxSs/pBBJDqv65lq1D4X+Qi6vndyUa5QN08Wn1K1r1iugbxxil9DiTP0XNbzm3KSK61bdz+M726ozsi/6634tNbQWK1YNLCYa5SysVRP+I28qDd28VL4RAA4QKBgEYdRd84UyVtO/guxKT4CXHG1eh8YCGkzyJUBBejHvSbAthezVdac8UQW+M3SiF92gWaV2XzRAc99qvqxCJQ67KEJmCo/U1CK7UaFSCUcJ62FpyGr9hIP+ww4xBE6UMTDzJ2gr+d7MMFopnNKgHQGPO1Q8UfggydqvL9S36NCqIx",
//                    "json",
//                    "UTF-8",
//                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAroGobEc+dZ5/+UkfmK4xgyeUkjisL6uOi+qGGBj4Ga2UaUeEuau9okKHDgvUxugiXYH5lLorhZbNtHN52sm8IcXdYOhBXLtE4oJBnqmDQ4zsa5ch8uEMBuomb51kmRB20f6jjVuqdzgoM4wcPthnyBOInrXhC2vgYWmWT2K2fo38fFHWd2dMLWxJ6w+HZxIItq/rF6pnLQOSs5p/1sj3b3uCMQpU5fYsSD55RTHYwtCoCMucCzadTvDqJ4qLlv+UBHSRon4bkZQqHlu+XOQDwzvyvo58XAjuS/33EsHlhpTW/Hp/USD+WjZ9UIwXhiFlYCW1pqE2Q/w2ukTQIFvddQIDAQAB",
//                    "RSA2");
//
//
//            //获得初始化的AlipayClient
//
//            //获取当前请求过来的地址
//            String urls=request.getRequestURL().toString();
//            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
//            alipayRequest.setReturnUrl("https://www.baidu.com/?tn=44004473_2_oem_dg");
//            alipayRequest.setNotifyUrl("https://www.baidu.com/?tn=44004473_2_oem_dg");//在公共参数中设置回跳和通知地址
//
//
//
//            alipayRequest.setBizContent("{" +
//                    "    \"out_trade_no\":\""+orderForm+"\"," +
//                    "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
//                    "    \"total_amount\":8888," +
//                    "    \"subject\":\""+videoId+"\"," +
//                    "    \"body\":\""+videoId+"\"," +
//                    "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
//                    "    \"extend_params\":{" +
//                    "    \"sys_service_provider_id\":\""+orderForm1+"\"" +
//                    "    }"+
//                    "  }");//填充业务参数
//            String form="";
//            try {
//                form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
//                AlipayTradePagePayResponse responses = alipayClient.pageExecute(alipayRequest);
//                if(responses.isSuccess()){
//                    System.out.println("调用成功");
//                } else {
//                    System.out.println("调用失败");
//                }
//            } catch (AlipayApiException e) {
//                e.printStackTrace();
//            }
//
//            //{    "out_trade_no":"4f59245f5bdf561f0f52",    "product_code":"FAST_INSTANT_TRADE_PAY",    "total_amount":8888,    "subject":"Iphone32 160G",    "body":"Iphone32 160G",    "passback_params":"merchantBizType%3d3C%26merchantBizNo%3d2016010101111",    "extend_params":{    "sys_service_provider_id":"92e7844abdd75710b6dd",    }  }
//            response.setContentType("text/html;charset=" +  "UTF-8");
//            response.getWriter().write(form);//直接将完整的表单html输出到页面
//            response.getWriter().flush();
//            response.getWriter().close();
//
//
//
//        }
//
//
//}
