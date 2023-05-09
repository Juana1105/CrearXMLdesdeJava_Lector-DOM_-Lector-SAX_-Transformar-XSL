<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/><!--SE ABRE Y SE CIERRA con la / al final-->
<xsl:template match="/">

<html>
<head>
    <style>
        body{
            margin:0 auto;
        }
        table{
            margin:0 auto;
            text-align:center;
            border-collapse: collapse;
        }
        th{
            background-color:#4521d9;
            color:white;
            padding:0.6em;
        }
        td{
            padding:0.4em;
        }
        .mas90{
            background-color:#70fa91;
        }
        .menos90{
            background-color:#86b3f7;
        }

    </style>

</head>
<body>

    <table border="1">
        <thead>
            <th>Nombre</th>
            <th>Plataforma</th>
            <th>Fecha Salida</th>
            <th>Nota Metacritic</th>
            <th>Nota Usuario</th>
        </thead>
        <tbody>
            <xsl:for-each select="/juegos/juego[./plataforma/text()=' Wii']">
                <xsl:sort select="notaMetacritic" order="descending"></xsl:sort>
                <xsl:if test = "notaMetacritic&gt;=90">
                    <tr class ='mas90'>
                        <td><xsl:value-of select="nombre"></xsl:value-of></td>
                        <td><xsl:value-of select="plataforma"/></td>
                        <td><xsl:value-of select="fechaSalida"/></td>
                        <td><xsl:value-of select="notaMetacritic"/></td>
                        <td><xsl:value-of select="notaUsuarios"/></td>
                    </tr>
                </xsl:if>
          
                <xsl:if test = "notaMetacritic&lt;90">
                    <tr class ='menos90'>
                        <td><xsl:value-of select="nombre"></xsl:value-of></td>
                        <td><xsl:value-of select="plataforma"/></td>
                        <td><xsl:value-of select="fechaSalida"/></td>
                        <td><xsl:value-of select="notaMetacritic"/></td>
                        <td><xsl:value-of select="notaUsuarios"/></td>
                    </tr>
                </xsl:if>
            </xsl:for-each>
        </tbody>
    </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>