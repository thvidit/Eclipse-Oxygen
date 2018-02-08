package org.example.company;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.16
 * 2018-01-24T10:18:56.139+05:30
 * Generated source version: 3.0.16
 * 
 */
@WebServiceClient(name = "employeeSearchService", 
                  wsdlLocation = "file:/C:/Users/M1043142/eclipse-workspace-oxygen/TopDownSoap/company.wsdl",
                  targetNamespace = "http://www.example.org/company") 
public class EmployeeSearchService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/company", "employeeSearchService");
    public final static QName EmployeeSearchPort = new QName("http://www.example.org/company", "employeeSearchPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/M1043142/eclipse-workspace-oxygen/TopDownSoap/company.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EmployeeSearchService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/M1043142/eclipse-workspace-oxygen/TopDownSoap/company.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EmployeeSearchService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmployeeSearchService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeSearchService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public EmployeeSearchService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public EmployeeSearchService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public EmployeeSearchService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns EmployeeSearchService
     */
    @WebEndpoint(name = "employeeSearchPort")
    public EmployeeSearchService getEmployeeSearchPort() {
        return super.getPort(EmployeeSearchPort, EmployeeSearchService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeSearchService
     */
    @WebEndpoint(name = "employeeSearchPort")
    public EmployeeSearchService getEmployeeSearchPort(WebServiceFeature... features) {
        return super.getPort(EmployeeSearchPort, EmployeeSearchService.class, features);
    }

}
