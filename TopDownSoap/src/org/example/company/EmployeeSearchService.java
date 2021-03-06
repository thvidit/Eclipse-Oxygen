package org.example.company;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.16
 * 2018-01-24T10:18:56.087+05:30
 * Generated source version: 3.0.16
 * 
 */
@WebService(targetNamespace = "http://www.example.org/company", name = "employeeSearchService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EmployeeSearchService {

    @WebResult(name = "EmployeeInfoList", targetNamespace = "http://www.example.org/company", partName = "employeeInfoList")
    @WebMethod(action = "http://www.example.org/company/employeeSearch")
    public EmployeeInfoWrapper employeeSearch(
        @WebParam(partName = "employeeIdList", name = "EmployeeIdList", targetNamespace = "http://www.example.org/company")
        EmployeeIdWrapper employeeIdList
    );
}
