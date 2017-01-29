/**
 * ***********************************************************************
 * Freeware Licence Agreement
 *
 * This licence agreement only applies to the free version of this software.
 *
 * Terms and Conditions
 *
 * BY DOWNLOADING, INSTALLING, USING, TRANSMITTING, DISTRIBUTING OR COPYING THIS SOFTWARE ("THE SOFTWARE"), YOU AGREE TO THE TERMS OF THIS AGREEMENT (INCLUDING THE SOFTWARE LICENCE AND DISCLAIMER OF WARRANTY) WITH METAMUG THE OWNER OF ALL RIGHTS IN RESPECT OF THE SOFTWARE.
 *
 * PLEASE READ THIS DOCUMENT CAREFULLY BEFORE USING THE SOFTWARE.
 *
 * IF YOU DO NOT AGREE TO ANY OF THE TERMS OF THIS LICENCE THEN DO NOT DOWNLOAD, INSTALL, USE, TRANSMIT, DISTRIBUTE OR COPY THE SOFTWARE.
 *
 * THIS DOCUMENT CONSTITUTES A LICENCE TO USE THE SOFTWARE ON THE TERMS AND CONDITIONS APPEARING BELOW.
 *
 * The Software is licensed to you without charge for use only upon the terms of this licence, and METAMUG TECHNOLOGIES LLP (hereafter METAMUG) reserves all rights not expressly granted to you. METAMUG retains ownership of all copies of the Software.
 *
 * 1. Licence
 *
 * You may use the Software without charge.
 *
 * You may freely distribute exact copies of the Software to anyone.
 *
 * The inclusion of the Software in any shareware, freeware or similar media compilation or distribution method whereby it is made available at cost (ie. sold) is strictly prohibited.
 *
 * The selling of the Software is strictly prohibited.
 * 2. Restrictions
 *
 * METAMUG reserves the right to revoke the above distribution right at any time, for any or no reason.
 *
 * YOU MAY NOT MODIFY, ADAPT, TRANSLATE, RENT, LEASE, LOAN, SELL, ONSELL, REQUEST DONATIONS OR CREATE DERIVATIVE WORKS BASED UPON THE SOFTWARE OR ANY PART THEREOF.
 *
 * The Software contains intellectual property and to protect them you may not decompile, reverse engineer, disassemble or otherwise reduce the Software to a humanly perceivable form. You agree not to divulge, directly or indirectly, until such intellectual property cease to be confidential, for any reason not your own fault.
 *
 * 3. Termination
 *
 * This licence is effective until terminated. The Licence will terminate automatically without notice from METAMUG if you fail to comply with any provision of this Licence. Upon termination you must destroy the Software and all copies thereof. You may terminate this Licence at any time by destroying the Software and all copies thereof. Upon termination of this licence for any reason you shall continue to be bound by the provisions of Section 2 above. Termination will be without prejudice to any rights METAMUG may have as a result of this agreement.
 *
 * 4. Disclaimer of Warranty, Limitation of Remedies
 *
 * TO THE FULL EXTENT PERMITTED BY LAW, METAMUG HEREBY EXCLUDES ALL CONDITIONS AND WARRANTIES, WHETHER IMPOSED BY STATUTE OR BY OPERATION OF LAW OR OTHERWISE, NOT EXPRESSLY SET OUT HEREIN. THE SOFTWARE, AND ALL ACCOMPANYING FILES, DATA AND MATERIALS ARE DISTRIBUTED "AS IS" AND WITH NO WARRANTIES OF ANY KIND, WHETHER EXPRESS OR IMPLIED. METAMUG DOES NOT WARRANT, GUARANTEE OR MAKE ANY REPRESENTATIONS REGARDING THE USE, OR THE RESULTS OF THE USE, OF THE SOFTWARE WITH RESPECT TO ITS CORRECTNESS, ACCURACY, RELIABILITY, CURRENTNESS OR OTHERWISE. THE ENTIRE RISK OF USING THE SOFTWARE IS ASSUMED BY YOU. METAMUG MAKES NO EXPRESS OR IMPLIED WARRANTIES OR CONDITIONS INCLUDING, WITHOUT LIMITATION, THE WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE WITH RESPECT TO THE SOFTWARE. NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY METAMUG, IT'S DISTRIBUTORS, AGENTS OR EMPLOYEES SHALL CREATE A WARRANTY, AND YOU MAY NOT RELY ON ANY SUCH INFORMATION OR ADVICE.
 *
 * IMPORTANT NOTE: Nothing in this Agreement is intended or shall be construed as excluding or modifying any statutory rights, warranties or conditions which by virtue of any national or state Fair Trading, Trade Practices or other such consumer legislation may not be modified or excluded. If permitted by such legislation, however, METAMUG's liability for any breach of any such warranty or condition shall be and is hereby limited to the supply of the Software licensed hereunder again as METAMUG at its sole discretion may determine to be necessary to correct the said breach.
 *
 * IN NO EVENT SHALL METAMUG BE LIABLE FOR ANY SPECIAL, INCIDENTAL, INDIRECT OR CONSEQUENTIAL DAMAGES (INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF BUSINESS PROFITS, BUSINESS INTERRUPTION, AND THE LOSS OF BUSINESS INFORMATION OR COMPUTER PROGRAMS), EVEN IF METAMUG OR ANY METAMUG REPRESENTATIVE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. IN ADDITION, IN NO EVENT DOES METAMUG AUTHORISE YOU TO USE THE SOFTWARE IN SITUATIONS WHERE FAILURE OF THE SOFTWARE TO PERFORM CAN REASONABLY BE EXPECTED TO RESULT IN A PHYSICAL INJURY, OR IN LOSS OF LIFE. ANY SUCH USE BY YOU IS ENTIRELY AT YOUR OWN RISK, AND YOU AGREE TO HOLD METAMUG HARMLESS FROM ANY CLAIMS OR LOSSES RELATING TO SUCH UNAUTHORISED USE.
 *
 * 5. General
 *
 * All rights of any kind in the Software which are not expressly granted in this Agreement are entirely and exclusively reserved to and by METAMUG.
 *
 * This Agreement shall be governed by the laws of the State of Maharastra, India. Exclusive jurisdiction and venue for all matters relating to this Agreement shall be in courts and fora located in the State of Maharastra, India, and you consent to such jurisdiction and venue. This agreement contains the entire Agreement between the parties hereto with respect to the subject matter hereof, and supersedes all prior agreements and/or understandings (oral or written). Failure or delay by METAMUG in enforcing any right or provision hereof shall not be deemed a waiver of such provision or right with respect to the instant or any subsequent breach. If any provision of this Agreement shall be held by a court of competent jurisdiction to be contrary to law, that provision will be enforced to the maximum extent permissible, and the remaining provisions of this Agreement will remain in force and effect.
 */
package com.metamug.mpath;

import com.metamug.commons.MPathUtil;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author anishhirlekar
 */
public class MPathTest {

    public static final String TEST_JSON = "{\n"
            + "   \"Port\":\n"
            + "   {\n"
            + "       \"alias\": \"defaultHttp\",\n"
            + "       \"Enabled\": \"true\",\n"
            + "       \"Number\": \"10092\",\n"
            + "       \"Protocol\": \"http\",\n"
            + "       \"KeepAliveTimeout\": \"20000\",\n"
            + "       \"ThreadPool\":\n"
            + "       {\n"
            + "           \"enabled\": \"false\",\n"
            + "           \"Max\": \"150\",\n"
            + "           \"ThreadPriority\": \"5\"\n"
            + "       },\n"
            + "       \"ExtendedProperties\":\n"
            + "       {\n"
            + "           \"Property\":\n"
            + "           [                         \n"
            + "               {\n"
            + "                   \"name\": \"connectionTimeout\",\n"
            + "                   \"D\": 20000\n"
            + "               },\n"
            + "               {\n"
            + "                   \"name\": \"connectionTimeout_Again!\",\n"
            + "                   \"D\": \"60000\"\n"
            + "               }\n"
            + "           ]\n"
            + "       }\n"
            + "   }\n"
            + "}";
    
    public static final String TEST_JSON2 = "[\n"
            + "   {\n"
            + "       \"Port\":\n"
            + "       {\n"
            + "           \"alias\": 8080,\n"
            + "           \"ThreadPool\":\n"
            + "           {\n"
            + "               \"enabled\": false,\n"
            + "               \"Max\": 150,\n"
            + "               \"ThreadPriority\": 5\n"
            + "           }\n"
            + "       }\n"
            + "   },\n"
            + "   {\n"
            + "       \"Port\":\n"
            + "       {\n"
            + "           \"alias\": 3306,\n"
            + "           \"ThreadPool\":\n"
            + "           {\n"
            + "               \"enabled\": true,\n"
            + "               \"Max\": 20,\n"
            + "               \"ThreadPriority\": 1\n"
            + "           }\n"
            + "       }\n"
            + "   }\n"
            + "]";
            

    public static final String TEST_XML = "<Resource version=\"1.1\" >\n"
            + "\n"
            + "	<Desc>Contains records for data type apple</Desc>\n"
            + "\n"
            + "	<Request method=\"GET\" item=\"true\" status=\"200\">\n"
            + "		<Param name=\"t\" blank=\"true\" min=\"1\" exists=\"table.column\" />\n"
            + "                \n"
            + "                <Sql when=\"@q eq 1\" type=\"query\">\n"
            + "                    select * from employee where employee_name = @v\n"
            + "                </Sql>\n"
            + "                <Sql when=\"@q eq 3\" type=\"update\">\n"
            + "                    <content>update employee set employee_name = @param2 where employee_id=@id\n"
            + "                </content></Sql>\n"
            + "	</Request>\n"
            + "	       \n"
            + "	<Request method=\"POST\" status=\"201\">\n"
            + "		<Desc>Request for creating an employee record.</Desc>\n"
            + "		<Sql type=\"update\">\n"
            + "		insert into employee \n"
            + "		(employee_name, employee_id) \n"
            + "		values(@name, @id)\n"
            + "		</Sql>\n"
            + "\n"
            + "	</Request>\n"
            + "\n"
            + "	<!--derived from request -->\n"
            + "	<Request method=\"PUT\" item=\"true\">\n"
            + "		<Execute className=\"com.mtg.Apple\" />\n"
            + "	</Request>\n"
            + "	\n"
            + "</Resource>\n"
            + "";

    public static final String TEST_XML2 = "<Resource version=\"1.1\" >\n"
            + "\n"
            + "	<Desc>Contains records for data type apple</Desc>\n"
            + "\n"
            + "	<Request method=\"GET\" item=\"true\" status=\"200\">\n"
            + "		<Param name=\"t\" blank=\"true\" min=\"1\" exists=\"table.column\" />\n"
            + "                \n"
            + "                <Sql when=\"@q eq 1\" type=\"query\">\n"
            + "                    select * from employee where employee_name = @v\n"
            + "                </Sql>\n"
            + "                <Sql when=\"@q eq 3\" type=\"update\">\n"
            + "                    <content>update employee set employee_name = @param2 where employee_id=@id\n"
            + "                </content>Illegal Content</Sql>\n"
            + "	</Request>\n"
            + "	       \n"
            + "	</Resource>";

    @Ignore
    @Test
    public void TestCase1() throws XPathExpressionException, IOException,
            SAXException, ParserConfigurationException {

        String equivalentXml = XML.toString(new JSONObject(TEST_JSON));
        String mKey1 = "Port.ExtendedProperties.Property[0].D";
        String mKey2 = "Port.ExtendedProperties.Property[1].D";
        String mKey3 = "Port.ThreadPool.Max";
        Object jsonVal1 = MPathUtil.getValueFromJson(TEST_JSON, mKey1);
        Object jsonVal2 = MPathUtil.getValueFromJson(TEST_JSON, mKey2);
        Object jsonVal3 = MPathUtil.getValueFromJson(TEST_JSON, mKey3);
        
        System.out.println("TEST_JSON: \n"+TEST_JSON);
        
        Object xmlVal1 = MPathUtil.getValueFromXml(equivalentXml, mKey1);
        Object xmlVal2 = MPathUtil.getValueFromXml(equivalentXml, mKey2);
        Object xmlVal3 = MPathUtil.getValueFromXml(equivalentXml, mKey3);
        /*
        System.out.println("x1: "+xmlVal1);
        System.out.println("x2: "+xmlVal2);
        System.out.println("x Val 3: "+xmlVal3);
         */
        Assert.assertArrayEquals(new String[]{jsonVal1.toString(), jsonVal2.toString(), jsonVal3.toString()},
                new Object[]{xmlVal1.toString(), xmlVal2.toString(), xmlVal3.toString()});

    }

    //@Ignore
    @Test
    public void TestCase2() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException{
        //System.out.println("TEST_JSON2: \n"+TEST_JSON2);
        String mPath = "[1].Port.ThreadPool.Max";
        String xmlMPath = "array[1].Port.ThreadPool.Max";
        Object valueFromJson = MPathUtil.getValueFromJson(TEST_JSON2, mPath);
        String testXml2 = XML.toString(new JSONArray(TEST_JSON2));
        //System.out.println("converted XML: \n"+testXml2);
        Object valueFromXml = MPathUtil.getValueFromXml(testXml2, xmlMPath);
        Assert.assertEquals(valueFromJson, valueFromXml);
        
    }
    
    @Ignore
    @Test
    public void TestCase3() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException {
        String equivalentJson = (XML.toJSONObject(TEST_XML)).toString();
        String mKey1 = "Resource.Request[0].method";
        String mKey2Xml = "Resource.Request[1].Sql";
        String mKey2Json = "Resource.Request[1].Sql.content";
        String mKey3 = "Resource.Request[0].Sql[1].content";
        String mKey4 = "Resource.Desc";
        String mKey5 = "Resource.version";
        //System.out.println(TEST_XML);
        String xmlVal1 = (MPathUtil.getValueFromXml(TEST_XML, mKey1)).toString();
        String xmlVal2 = (MPathUtil.getValueFromXml(TEST_XML, mKey2Xml)).toString();
        String jsonVal1 = (MPathUtil.getValueFromJson(equivalentJson, mKey1)).toString();
        String jsonVal2 = (MPathUtil.getValueFromJson(equivalentJson, mKey2Json)).toString();
        String xmlVal3 = (MPathUtil.getValueFromXml(TEST_XML, mKey3)).toString();
        String jsonVal3 = (MPathUtil.getValueFromJson(equivalentJson, mKey3)).toString();
        String xmlVal4 = (MPathUtil.getValueFromXml(TEST_XML, mKey4)).toString();
        String jsonVal4 = (MPathUtil.getValueFromJson(equivalentJson, mKey4)).toString();
        String xmlVal5 = (MPathUtil.getValueFromXml(TEST_XML, mKey5)).toString();
        String jsonVal5 = (MPathUtil.getValueFromJson(equivalentJson, mKey5)).toString();

        Assert.assertArrayEquals(new String[]{xmlVal1, xmlVal2, xmlVal3, xmlVal4, xmlVal5}, new String[]{jsonVal1, jsonVal2, jsonVal3, jsonVal4, jsonVal5});
    }
    
    @Ignore
    @Test
    public void FailCase1() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException {
        //System.out.println(TEST_XML2);
        String mKey1 = "Resource.Request.Sql[1]";
        Assert.assertNull(MPathUtil.getValueFromXml(TEST_XML2, mKey1));
    }

    @Ignore
    @Test
    public void FailCase2() throws IOException, SAXException, XPathExpressionException, ParserConfigurationException {
        String garbageMKey = "ChangeMeToTestGarbageValues";
        Assert.assertNull(MPathUtil.getValueFromXml(TEST_XML, garbageMKey));
    }
}
