package com.rimi.esports.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 发送短信
 *
 * @author Wang Xiaoping
 * @date 2019/11/4 16:22
 */
public final class SendMessageUtils {

    private SendMessageUtils() {
    }

    public static void sendMessage(String telephone, String number){

            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FovhEb6FLzhBnVya8sR", "XteD9K2gczwZbQ0d3vwP2AZhWXO7Ko");
            IAcsClient client = new DefaultAcsClient(profile);

            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain("dysmsapi.aliyuncs.com");
            request.setVersion("2017-05-25");
            request.setAction("SendSms");
            request.putQueryParameter("RegionId", "cn-hangzhou");
            request.putQueryParameter("PhoneNumbers", telephone);
            request.putQueryParameter("SignName", "享动");
            request.putQueryParameter("TemplateCode", "SMS_176926742");
            request.putQueryParameter("TemplateParam", number);
            try {
                CommonResponse response = client.getCommonResponse(request);
                System.out.println(response.getData());
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }


}
