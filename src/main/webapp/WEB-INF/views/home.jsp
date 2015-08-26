<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf8"%>
<html>
<head>
	<title>${title}</title>
</head>
<body>
<P>去往${end_station}的列车还有${end_station_min}分${end_station_sec}秒到达</P>
<P>去往${start_station}的列车还有${start_station_min}分${start_station_sec}秒到达</P>
</body>
</html>