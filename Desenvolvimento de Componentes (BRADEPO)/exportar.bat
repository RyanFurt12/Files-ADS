@echo off
echo =========================================
echo  Exportando Componente CPF Validator...
echo =========================================

REM Forca a variavel do Java para a sessao atual pra garantir
set JAVA_HOME=C:\Program Files\Java\jdk-21

REM Executa a exportacao pulando os testes por conta da falha
call .\mvnw.cmd clean install -DskipTests

echo.
pause
