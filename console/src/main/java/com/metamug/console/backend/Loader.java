/** ***********************************************************************
 *Freeware License Agreement
 *
 *This license agreement only applies to the free version of this software.
 *
 *Terms and Conditions
 *
 *BY DOWNLOADING, INSTALLING, USING, TRANSMITTING, DISTRIBUTING OR COPYING THIS SOFTWARE ("THE SOFTWARE"), YOU AGREE TO THE TERMS OF THIS AGREEMENT (INCLUDING THE SOFTWARE LICENSE AND DISCLAIMER OF WARRANTY) WITH METAMUG THE OWNER OF ALL RIGHTS IN RESPECT OF THE SOFTWARE.
 *
 *PLEASE READ THIS DOCUMENT CAREFULLY BEFORE USING THE SOFTWARE.
 *
 *IF YOU DO NOT AGREE TO ANY OF THE TERMS OF THIS LICENSE THEN DO NOT DOWNLOAD, INSTALL, USE, TRANSMIT, DISTRIBUTE OR COPY THE SOFTWARE.
 *
 *THIS DOCUMENT CONSTITUTES A LICENSE TO USE THE SOFTWARE ON THE TERMS AND CONDITIONS APPEARING BELOW.
 *
 *The Software is licensed to you without charge for use only upon the terms of this license, and METAMUG TECHNOLOGIES LLP (hereafter METAMUG) reserves all rights not expressly granted to you. METAMUG retains ownership of all copies of the Software.
 *
 *1. License
 *
 *You may use the Software without charge.
 *
 *You may freely distribute exact copies of the Software to anyone.
 *
 *The inclusion of the Software in any Shareware, Freeware or similar media compilation or distribution method whereby it is made available at cost (ie. sold) is strictly prohibited.
 *
 *The selling of the Software is strictly prohibited.
 *2. Restrictions
 *
 *METAMUG reserves the right to revoke the above distribution right at any time, for any or no reason.
 *
 *YOU MAY NOT MODIFY, ADAPT, TRANSLATE, RENT, LEASE, LOAN, SELL, ONSELL, REQUEST DONATIONS OR CREATE DERIVATIVE WORKS BASED UPON THE SOFTWARE OR ANY PART THEREOF.
 *
 *The Software contains intellectual property and to protect them you may not decompile, reverse engineer, disassemble or otherwise reduce the Software to a humanly perceivable form. You agree not to divulge, directly or indirectly, until such intellectual property cease to be confidential, for any reason not your own fault.
 *
 *3. Termination
 *
 *This license is effective until terminated. The License will terminate automatically without notice from METAMUG if you fail to comply with any provision of this License. Upon termination you must destroy the Software and all copies thereof. You may terminate this License at any time by destroying the Software and all copies thereof. Upon termination of this license for any reason you shall continue to be bound by the provisions of Section 2 above. Termination will be without prejudice to any rights METAMUG may have as a result of this agreement.
 *
 *4. Disclaimer of Warranty, Limitation of Remedies
 *
 *TO THE FULL EXTENT PERMITTED BY LAW, METAMUG HEREBY EXCLUDES ALL CONDITIONS AND WARRANTIES, WHETHER IMPOSED BY STATUTE OR BY OPERATION OF LAW OR OTHERWISE, NOT EXPRESSLY SET OUT HEREIN. THE SOFTWARE, AND ALL ACCOMPANYING FILES, DATA AND MATERIALS ARE DISTRIBUTED "AS IS" AND WITH NO WARRANTIES OF ANY KIND, WHETHER EXPRESS OR IMPLIED. METAMUG DOES NOT WARRANT, GUARANTEE OR MAKE ANY REPRESENTATIONS REGARDING THE USE, OR THE RESULTS OF THE USE, OF THE SOFTWARE WITH RESPECT TO ITS CORRECTNESS, ACCURACY, RELIABILITY, CURRENTNESS OR OTHERWISE. THE ENTIRE RISK OF USING THE SOFTWARE IS ASSUMED BY YOU. METAMUG MAKES NO EXPRESS OR IMPLIED WARRANTIES OR CONDITIONS INCLUDING, WITHOUT LIMITATION, THE WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE WITH RESPECT TO THE SOFTWARE. NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY METAMUG, IT'S DISTRIBUTORS, AGENTS OR EMPLOYEES SHALL CREATE A WARRANTY, AND YOU MAY NOT RELY ON ANY SUCH INFORMATION OR ADVICE.
 *
 *IMPORTANT NOTE: Nothing in this Agreement is intended or shall be construed as excluding or modifying any statutory rights, warranties or conditions which by virtue of any national or state Fair Trading, Trade Practices or other such consumer legislation may not be modified or excluded. If permitted by such legislation, however, METAMUG's liability for any breach of any such warranty or condition shall be and is hereby limited to the supply of the Software licensed hereunder again as METAMUG at its sole discretion may determine to be necessary to correct the said breach.
 *
 *IN NO EVENT SHALL METAMUG BE LIABLE FOR ANY SPECIAL, INCIDENTAL, INDIRECT OR CONSEQUENTIAL DAMAGES (INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF BUSINESS PROFITS, BUSINESS INTERRUPTION, AND THE LOSS OF BUSINESS INFORMATION OR COMPUTER PROGRAMS), EVEN IF METAMUG OR ANY METAMUG REPRESENTATIVE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. IN ADDITION, IN NO EVENT DOES METAMUG AUTHORIZE YOU TO USE THE SOFTWARE IN SITUATIONS WHERE FAILURE OF THE SOFTWARE TO PERFORM CAN REASONABLY BE EXPECTED TO RESULT IN A PHYSICAL INJURY, OR IN LOSS OF LIFE. ANY SUCH USE BY YOU IS ENTIRELY AT YOUR OWN RISK, AND YOU AGREE TO HOLD METAMUG HARMLESS FROM ANY CLAIMS OR LOSSES RELATING TO SUCH UNAUTHORIZED USE.
 *
 *5. General
 *
 *All rights of any kind in the Software which are not expressly granted in this Agreement are entirely and exclusively reserved to and by METAMUG.
 *
 *This Agreement shall be governed by the laws of the State of Maharashtra, India. Exclusive jurisdiction and venue for all matters relating to this Agreement shall be in courts and fora located in the State of Maharashtra, India, and you consent to such jurisdiction and venue. This agreement contains the entire Agreement between the parties hereto with respect to the subject matter hereof, and supersedes all prior agreements and/or understandings (oral or written). Failure or delay by METAMUG in enforcing any right or provision hereof shall not be deemed a waiver of such provision or right with respect to the instant or any subsequent breach. If any provision of this Agreement shall be held by a court of competent jurisdiction to be contrary to law, that provision will be enforced to the maximum extent permissible, and the remaining provisions of this Agreement will remain in force and effect.
 */
package com.metamug.console.backend;

import static com.metamug.console.backend.ConfigManager.KEY_PROPERTIES;
import com.metamug.console.daos.AppDAO;
import com.metamug.console.exception.MetamugError;
import com.metamug.console.exception.MetamugException;
import com.metamug.console.services.PropertiesService;
import com.metamug.console.util.FileUtil;
import com.metamug.console.util.Util;
import static com.metamug.console.util.Util.OUTPUT_FOLDER;
import static com.metamug.console.util.Util.TEMP_FOLDER;
import com.metamug.parser.exception.ResourceTestException;
import com.metamug.parser.service.ParserService;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.commons.io.FilenameUtils;
import org.codehaus.plexus.util.FileUtils;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/**
 *
 * @author anishhirlekar
 */
public class Loader {
    protected final String appName;
    protected final JSONObject appConfig;
    
    public Loader(String appName) throws FileNotFoundException{
        this.appName = appName;
        appConfig = new ConfigManager(appName).getConfig();    
    }
    
    protected void unzipAppTemplate() throws MetamugException {
        File webappDirectory = new File(OUTPUT_FOLDER + File.separator + appName);
        if (!webappDirectory.isDirectory()) {
            try {
                FileUtil.unzip(Loader.class.getClassLoader().getResource("app-template-v0.1.zip").toURI().getPath(),
                        TEMP_FOLDER + File.separator + appName);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            throw new MetamugException(MetamugError.APP_EXISTS);
        }
    }
    
    /**
     * Picks up app from given directory and places inside the webapps output directory
     *
     * @param sourceDir Folder from which the app has to be picked
     * @throws com.metamug.console.exception.MetamugException
     */
    private void deployWebapp() throws MetamugException {
        File outputAppDir = new File(OUTPUT_FOLDER + File.separator + appName);
        if (!outputAppDir.isDirectory()) {
            File sourceAppDir = new File(TEMP_FOLDER + File.separator + appName);
            try {
                FileUtil.copyFolder(sourceAppDir, outputAppDir);
                FileUtils.deleteDirectory(sourceAppDir);
            } catch (IOException ex) {
                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            throw new MetamugException(MetamugError.APP_EXISTS);
        }
    }
    
    public void load(String domain) throws MetamugException, TransformerException, TransformerConfigurationException, 
            SAXException, IOException, ParserConfigurationException, ResourceTestException{
        File appDir = new File(OUTPUT_FOLDER + File.separator + appName);
        if(!appDir.exists()){
            createWebapp();
            //set datasources in context.xml
            ContextManager cx = new ContextManager(appName,appConfig);
            cx.setDatasources();
            //copy app folder to /webapps  
            deployWebapp();
            // set deployed flag 
            new AppDAO().deployApp(appName);
            if(domain!=null){
                generateResources(domain);
            }
        } else{
            //app already deployed
        }
    }
    
    private void generateResources(String domain) throws ResourceTestException, IOException {       
        File appResourceFolder = new File(Util.XML_RESOURCE_FOLDER + File.separator + appName);
        File[] versionFolders = appResourceFolder.listFiles();
        if(versionFolders != null){
            try {
                //wait for 34 seconds to let the backend deploy and then generate resources
                TimeUnit.SECONDS.sleep(34);
            } catch (InterruptedException ex) {
                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (File vFolder : versionFolders) {
                if (vFolder.isDirectory()) {
                    File[] resourceFiles = vFolder.listFiles();
                    for (File resourceFile : resourceFiles) {
                        String resourceFilePath = resourceFile.getPath();
                        String ext = FilenameUtils.getExtension(resourceFilePath);
                        if (ext.equals("xml")) {
                            ParserService parseService = new ParserService();
                            try {
                                //System.out.println(queryMap);
                                parseService.transform(resourceFile, appName, false, Util.OUTPUT_FOLDER, domain);
                            } catch (PropertyVetoException ex) {
                                Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (XPathExpressionException | SAXException | XMLStreamException | TransformerException | JAXBException | URISyntaxException | SQLException | ClassNotFoundException ex) {
                                Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void createWebapp() throws MetamugException, ParserConfigurationException, 
                SAXException, IOException, TransformerException{
        unzipAppTemplate();            
        //add properties from config to web.xml
        JSONObject props = appConfig.getJSONObject(KEY_PROPERTIES);
        PropertiesService ps = new PropertiesService();
        Iterator<String> i = props.keys();
        while(i.hasNext()) {
            String key = i.next();
            String value = props.getString(key);
            ps.addProperty(appName, key, value, TEMP_FOLDER);
        }       
    }
    
    public void unload() throws IOException {
        File webappFolder = new File(OUTPUT_FOLDER + File.separator + appName);
        FileUtil.recursiveDelete(webappFolder);
        new AppDAO().undeployApp(appName);
    }
    
    public void reload(String domain) throws MetamugException, TransformerException, TransformerConfigurationException,
            SAXException, IOException, ParserConfigurationException, ResourceTestException {
        unload();        
        load(domain);
    }
    
    public boolean isBackendLoaded(String domain){
        try {
            URL obj = new URL(domain+"/"+appName);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            if(responseCode == 200)
                return true;
            
        } catch (IOException ex) {
            //Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
