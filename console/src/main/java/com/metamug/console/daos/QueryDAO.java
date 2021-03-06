/**
 * ***********************************************************************
 * Freeware License Agreement
 *
 * This license agreement only applies to the free version of this software.
 *
 * Terms and Conditions
 *
 * BY DOWNLOADING, INSTALLING, USING, TRANSMITTING, DISTRIBUTING OR COPYING THIS SOFTWARE ("THE SOFTWARE"), YOU AGREE TO THE TERMS OF THIS AGREEMENT (INCLUDING THE SOFTWARE LICENSE AND DISCLAIMER OF WARRANTY) WITH METAMUG THE OWNER OF ALL RIGHTS IN RESPECT OF THE SOFTWARE.
 *
 * PLEASE READ THIS DOCUMENT CAREFULLY BEFORE USING THE SOFTWARE.
 *
 * IF YOU DO NOT AGREE TO ANY OF THE TERMS OF THIS LICENSE THEN DO NOT DOWNLOAD, INSTALL, USE, TRANSMIT, DISTRIBUTE OR COPY THE SOFTWARE.
 *
 * THIS DOCUMENT CONSTITUTES A LICENSE TO USE THE SOFTWARE ON THE TERMS AND CONDITIONS APPEARING BELOW.
 *
 * The Software is licensed to you without charge for use only upon the terms of this license, and METAMUG TECHNOLOGIES LLP (hereafter METAMUG) reserves all rights not expressly granted to you. METAMUG retains ownership of all copies of the Software.
 *
 * 1. License
 *
 * You may use the Software without charge.
 *
 * You may freely distribute exact copies of the Software to anyone.
 *
 * The inclusion of the Software in any Shareware, Freeware or similar media compilation or distribution method whereby it is made available at cost (ie. sold) is strictly prohibited.
 *
 * The selling of the Software is strictly prohibited.
 * 2. Restrictions
 *
 * METAMUG reserves the right to revoke the above distribution right at any time, for any or no reason.
 *
 * YOU MAY NOT MODIFY, ADAPT, TRANSLATE, RENT, LEASE, LOAN, SELL, ONSELL, REQUEST DONATIONS OR CREATE DERIVATIVE WORKS BASED UPON THE SOFTWARE OR ANY PART THEREOF.
 *
 * The Software contains intellectual property and to protect them you may not decompile, reverse engineer, disassemble or otherwise reduce the Software to a humanly perceivable form. You agree not to divulge, directly or indirectly, until such intellectual property ceases to be confidential, for any reason not your own fault.
 *
 * 3. Termination
 *
 * This license is effective until terminated. The License will terminate automatically without notice from METAMUG if you fail to comply with any provision of this License. Upon termination, you must destroy the Software and all copies thereof. You may terminate this License at any time by destroying the Software and all copies thereof. Upon termination of this license for any reason, you shall continue to be bound by the provisions of Section 2 above. Termination will be without prejudice to any rights METAMUG may have as a result of this agreement.
 *
 * 4. Disclaimer of Warranty, Limitation of Remedies
 *
 * TO THE FULL EXTENT PERMITTED BY LAW, METAMUG HEREBY EXCLUDES ALL CONDITIONS AND WARRANTIES, WHETHER IMPOSED BY STATUTE OR BY OPERATION OF LAW OR OTHERWISE, NOT EXPRESSLY SET OUT HEREIN. THE SOFTWARE, AND ALL ACCOMPANYING FILES, DATA AND MATERIALS ARE DISTRIBUTED "AS IS" AND WITH NO WARRANTIES OF ANY KIND, WHETHER EXPRESS OR IMPLIED. METAMUG DOES NOT WARRANT, GUARANTEE OR MAKE ANY REPRESENTATIONS REGARDING THE USE, OR THE RESULTS OF THE USE, OF THE SOFTWARE WITH RESPECT TO ITS CORRECTNESS, ACCURACY, RELIABILITY, CURRENTNESS OR OTHERWISE. THE ENTIRE RISK OF USING THE SOFTWARE IS ASSUMED BY YOU. METAMUG MAKES NO EXPRESS OR IMPLIED WARRANTIES OR CONDITIONS INCLUDING, WITHOUT LIMITATION, THE WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE WITH RESPECT TO THE SOFTWARE. NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY METAMUG, IT'S DISTRIBUTORS, AGENTS OR EMPLOYEES SHALL CREATE A WARRANTY, AND YOU MAY NOT RELY ON ANY SUCH INFORMATION OR ADVICE.
 *
 * IMPORTANT NOTE: Nothing in this Agreement is intended or shall be construed as excluding or modifying any statutory rights, warranties or conditions which by virtue of any national or state Fair Trading, Trade Practices or other such consumer legislation may not be modified or excluded. If permitted by such legislation, however, METAMUG's liability for any breach of any such warranty or condition shall be and is hereby limited to the supply of the Software licensed hereunder again as METAMUG at its sole discretion may determine to be necessary to correct the said breach.
 *
 * IN NO EVENT SHALL METAMUG BE LIABLE FOR ANY SPECIAL, INCIDENTAL, INDIRECT OR CONSEQUENTIAL DAMAGES (INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOSS OF BUSINESS PROFITS, BUSINESS INTERRUPTION, AND THE LOSS OF BUSINESS INFORMATION OR COMPUTER PROGRAMS), EVEN IF METAMUG OR ANY METAMUG REPRESENTATIVE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. IN ADDITION, IN NO EVENT DOES METAMUG AUTHORIZE YOU TO USE THE SOFTWARE IN SITUATIONS WHERE FAILURE OF THE SOFTWARE TO PERFORM CAN REASONABLY BE EXPECTED TO RESULT IN A PHYSICAL INJURY, OR IN LOSS OF LIFE. ANY SUCH USE BY YOU IS ENTIRELY AT YOUR OWN RISK, AND YOU AGREE TO HOLD METAMUG HARMLESS FROM ANY CLAIMS OR LOSSES RELATING TO SUCH UNAUTHORIZED USE.
 *
 * 5. General
 *
 * All rights of any kind in the Software which are not expressly granted in this Agreement are entirely and exclusively reserved to and by METAMUG.
 *
 * This Agreement shall be governed by the laws of the State of Maharashtra, India. Exclusive jurisdiction and venue for all matters relating to this Agreement shall be in courts and fora located in the State of Maharashtra, India, and you consent to such jurisdiction and venue. This agreement contains the entire Agreement between the parties hereto with respect to the subject matter hereof, and supersedes all prior agreements and/or understandings (oral or written). Failure or delay by METAMUG in enforcing any right or provision hereof shall not be deemed a waiver of such provision or right with respect to the instant or any subsequent breach. If any provision of this Agreement shall be held by a court of competent jurisdiction to be contrary to law, that provision will be enforced to the maximum extent permissible, and the remaining provisions of this Agreement will remain in force and effect.
 */
package com.metamug.console.daos;

import com.metamug.console.services.ConnectionProvider;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kainix
 */
public class QueryDAO {

    public QueryDAO() {
    }

    /**
     *
     * @param con Database connection
     * @param query SQL statement to execute
     * @param db Name of database
     * @param userId Number to uniquely identify a User
     * @param appId Number to uniquely identify a backend
     * @return HTML Table in form of string.
     */
    public JSONObject executeSql(Connection con, String query, String db, long appId, int userId) {
        boolean isSuccessfull = true;
        JSONObject tableData = new JSONObject();
        JSONArray dataArray = new JSONArray();
        JSONArray columnHeader = new JSONArray();
        try {
            int recordCount = 0;
            Statement statement = con.createStatement();
            statement.execute("use " + db);
            boolean status = statement.execute(query);
            tableData.put("status", 200);
            if (status) {
                ResultSet resultSet = statement.getResultSet();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columnHeader.put(metaData.getColumnLabel(i));
                }
                tableData.put("columnHeaders", columnHeader);
                while (resultSet.next()) {
                    recordCount++;
                    tableData.put("recordCount", recordCount);
                    JSONArray array = new JSONArray();
                    for (int i = 1; i <= columnCount; i++) {
                        if (resultSet.getObject(i) == Boolean.TRUE) {
                            array.put("true");
                        } else if (resultSet.getObject(i) == Boolean.FALSE) {
                            array.put("false");
                        } else {
                            array.put(resultSet.getObject(i));
                        }
                    }
                    tableData.accumulate("data", array);
                }
                if (recordCount < 1) {
                    tableData.put("status", 204);
                }
            } else {
                int executeUpdate = statement.getUpdateCount();
                tableData.put("data", dataArray.put(executeUpdate + " Record(s) Updated."));
            }
        } catch (SQLException ex) {
            isSuccessfull = false;
            String message;
            int status = 500;
            Logger.getLogger(QueryDAO.class.getName()).log(Level.SEVERE, "SQL error code:{0}", ex.getErrorCode());
            switch (ex.getErrorCode()) {
                case 1044:
                    message = "Database Access Denied for user";
                    status = 403;
                    break;
                case 1045:
                    message = "Access Denied for user";
                    status = 403;
                    break;
                case 1142:
                    message = "Table Access Denied for user";
                    status = 403;
                    break;
                case 1146:
                    message = " Table doesn't exist.";
                    Pattern pattern = Pattern.compile("_db\\.(\\w+)");
                    Matcher matcher = pattern.matcher(ex.getLocalizedMessage());
                    while (matcher.find()) {
                        message = matcher.group(1) + message;
                    }
                    break;
                case 1227:
                    message = "Access Denied for user special privilege required";
                    status = 403;
                    break;
                case 1211:
                    message = "Can't create new users";
                    status = 403;
                    break;
                case 1370:
                    message = "Procedure Access Denied for user";
                    status = 403;
                    break;
                case 1403:
                    message = "No grant defined for procedure";
                    status = 403;
                    break;
                case 1410:
                    message = "Can't create User with GRANT";
                    status = 403;
                    break;
                case 1448:
                    message = "Requires SUPER privilege";
                    status = 403;
                    break;
                default:
                    message = ex.getLocalizedMessage();
            }
            tableData.put("status", status);
            tableData.put("data", dataArray.put(message.trim()));
//            Logger.getLogger(QueryDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        logQuery(userId, appId, query, isSuccessfull);
        return tableData;
    }

    public void logQuery(int userId, long appId, String query, boolean isSuccessfull) {
        try (Connection con = ConnectionProvider.getInstance().getConnection()) {
            try (PreparedStatement statement = con.prepareStatement("INSERT INTO console_query_log (query,user_id,app_id,status) VALUES(?,?,?,?)")) {
                statement.setString(1, query);
                statement.setInt(2, userId);
                statement.setLong(3, appId);
                statement.setBoolean(4, isSuccessfull);
                statement.execute();
            }
        } catch (IOException | SQLException | PropertyVetoException | ClassNotFoundException ex) {
            Logger.getLogger(QueryDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Deprecated
    public JSONObject getQueryLogs(Integer userId, long appId) throws SQLException, PropertyVetoException, ClassNotFoundException, IOException {
        JSONObject logQueryRecords = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONArray columnHeader = new JSONArray();
        columnHeader.put("query").put("status").put("executed_on");
        try (Connection con = ConnectionProvider.getInstance().getConnection()) {
            try (PreparedStatement statement = con.prepareStatement("SELECT query,status,executed_on FROM console_query_log WHERE user_id=? AND app_id=? ORDER BY executed_on DESC LIMIT 100")) {
                statement.setInt(1, userId);
                statement.setLong(2, appId);
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        JSONObject queryLogRecord = new JSONObject();
                        queryLogRecord.put("query", result.getString("query"));
                        queryLogRecord.put("status", result.getBoolean("status") ? "true" : "false");
                        queryLogRecord.put("executed_on", result.getTimestamp("executed_on"));
                        jsonArray.put(queryLogRecord);
                    }
                }
            }
        }
        logQueryRecords.put("columnHeaders", columnHeader);
        logQueryRecords.put("data", jsonArray);
        return logQueryRecords;
    }
}
