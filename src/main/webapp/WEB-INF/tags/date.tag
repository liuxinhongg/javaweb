<%@tag import="com.bdxh.kmsale.utils.DateUtils"%>
<%@tag pageEncoding="UTF-8"%>
<%@attribute name="date" type="java.util.Date" required="true" description="时间" %>
<%@attribute name="format" type="java.lang.String" required="true" description="时间" %>
<%=DateUtils.convert2String(date, format)%>