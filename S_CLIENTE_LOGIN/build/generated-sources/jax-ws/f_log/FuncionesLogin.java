
package f_log;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Funciones_Login", targetNamespace = "http://f_log/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FuncionesLogin {


    /**
     * 
     * @param usuario
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://f_log/", className = "f_log.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://f_log/", className = "f_log.LoginResponse")
    @Action(input = "http://f_log/Funciones_Login/loginRequest", output = "http://f_log/Funciones_Login/loginResponse")
    public String login(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario);

}
