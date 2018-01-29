package co.com.almundo.servlet;

import com.meterware.httpunit.*;
import junit.framework.*;

public class RecibellamadasServletTest extends TestCase {
    
    static final int HILOS_A_EJECUTAR = 30;
    static final String URL_RECURSO = "http://localhost:8088/callcenter/recibeLlamadas";
    
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite() {
        return new TestSuite(RecibellamadasServletTest.class);
    }

    public RecibellamadasServletTest(String name) {
        super(name);
    }

    public WebResponse ejecutarPeticion(WebConversation conversacion, WebRequest request) throws Exception {
        WebResponse response = null;
        try {
            response = conversacion.getResponse(request);
        } catch (HttpNotFoundException nfe) {
            System.err.println("No se encontro el recurso '" + request.getURL());
            throw nfe;
        }
        return response;
    }

 
    public void testConcurrencia() throws Exception {
        WebConversation conversacion = new WebConversation();
        WebRequest request = new GetMethodWebRequest(URL_RECURSO);
        
        for (int i=0; i<HILOS_A_EJECUTAR; i++){
            ejecutarPeticion(conversacion, request);
        }
        
    }
    
}
