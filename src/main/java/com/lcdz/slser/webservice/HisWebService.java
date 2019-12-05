package com.lcdz.slser.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author QinZhenGuo
 * @date 2018/8/2 8:51
 */

@WebService
public interface HisWebService {

    @WebMethod
    @WebResult(name = "ReturnXml")
    String hiser(@WebParam(name = "InputXml") String InputXml);

}
