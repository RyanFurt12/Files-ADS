# 1) Inicie o Ubuntu e abra um terminal de modo texto (abra um aplicativo “Terminal” na interface gráfica ou abra um terminal de modo texto do sistema com CTRL+ALT+Fx, sendo x igual a 3, 4, 5, etc).
# 2) Exiba o diretório atual.
pwd
# 3) Mude para o diretório /etc.
cd /etc
# 4) Mude para o home do seu usuário (/home/nome_do_seu_usuário) pressionando apenas três teclas.
cd
# 5) Mude para o diretório /var/log usando o menor número de teclas possível.
cd /var/log
# 6) Vá para o diretório anterior ao diretório atual.
cd ..
# 7) Vá para o diretório raiz do sistema (/).
cd /
# 8) Liste o conteúdo do diretório raiz.
ls /
# 9) Liste o conteúdo do diretório raiz com detalhes.
ls -l /
# 10) Sem sair do diretório atual, liste o conteúdo do /etc.
ls /etc
# 11) Sem sair do diretório atual, liste o conteúdo do /usr/bin.
ls /usr/bin
# 12) Sem sair do diretório atual, liste o conteúdo de ~.
ls ~ 
# 13) Liste todos os arquivos (incluindo arquivos ocultos) do seu diretório home(/home/nome_do_seu_usuário).
ls -a
# 14) Vá para seu diretório home (/home/nome_do_seu_usuário) e crie um diretório chamado testdir.
cd && mkdir testedir
# 15) Mude para o diretório /etc e, sem sair dele, crie um diretório chamado novodir dentro do seu diretório home (/home/nome_do_seu_usuário).
cd /etc
mkdir /home/aluno/novodir
# 16) Vá para o diretório home do seu usuário e crie, usando um só comando, os diretórios dir1/dir2/dir3 (dir3 é um subdiretório de dir2, dir2 é um subdiretório de dir1 e dir1 é um subdiretório do home do seu usuário).
cd
mkdir dir1/dir2/dir3
# 17) Remova o diretório novodir.
rm -rf novodir
# 18) Remova os diretórios dir1/dir2/dir3 com um só comando.
rm -rf dir1
# 19) Liste o conteúdo do diretório home da máquina (/home).
ls /home
# 20) Exiba o tipo do arquivo /bin/cat, /etc/passwd e /usr/bin/passwd.
file /bin/cat /etc/passwd /usr/bin/passwd
# 21) Crie o diretório ~/tc e entre nele.
mkdir ~/tc && cd ~/tc
# 22) Crie os arquivos arq01.txt e arq02.txt dentro do diretório ~/tc.
touch arq01.txt arq02.txt
# 23) Crie uma cópia do arquivo arq01.txt com o nome de arq01.txt.bkp.
cp arq01.txt arq01.txt.bkp
# 24) Renomeie o arquivo arq01.txt.bkp para BKP.ARQ01.TXT.
mv arq01.txt.bkp BKP.ARQ01.TXT
# 25) Crie um diretório chamado ~/tst-backup e copie todos os arquivos que de ~/tc nele com um só comando.
cp ~/tc/* ~/tst-backup -r
# 26) Use um único comando para remover o diretório ~/tstbackup e todos os arquivos que existem dentro dele.
rm -rf ~/tst-backup
# 27) Crie um diretório ~/etcbackup e copie todos os arquivos com extensão .conf que existam dentro do diretório /etc para dentro dele, inclusive de subdiretórios.
mkdir ~/etcbackup
find /etc -type f -name "*.conf" -exec cp --parents {} ~/etcbackup \;
# 28) Dentro do seu diretório home (/home/nome_do_seu_usuário), crie arquivos chamados a.txt, b.txt e c.txt.
cd ~
touch a.txt b.txt c.txt
# 29) Vá para o diretório /etc e, a partir de lá, crie um diretório chamado arquivos dentro do diretório home do seu usuário (/home/nome_do_seu_usuário). Depois, sem sair do diretório /etc, copie os arquivos a.txt, b.txt e c.txt para dentro do diretório arquivos.
cd /etc
mkdir /home/aluno/arquivos
cp ~/a.txt ~/b.txt ~/c.txt /home/aluno/arquivos
# 30) Sem sair do diretório /etc, apague os arquivos a.txt, b.txt e c.txt que estão no diretório ~/arquivos. Depois, volte para o seu diretório home (/home/nome_do_seu_usuário).
rm /home/aluno/arquivos/a.txt /home/aluno/arquivos/b.txt /home/aluno/arquivos/c.txt
cd ~
# 31) Mostre as primeiras 12 linhas de um arquivo que esteja no /etc (teste com vários).
head -n 12 /etc/passwd
# 32) Mostre a última linha do arquivo passwd que se encontra no diretório /etc.
tail -n 1 /etc/passwd
# 33) Use o cat para criar um aquivo chamado count com o seguinte conteúdo:
#     Linha um
#     Linha dois
#     Linha três
#     Linha quatro
#     Linha cinco
cat > count <<EOF
Linha um
Linha dois
Linha três
Linha quatro
Linha cinco
EOF
# 34) Use o cp para criar um arquivo de backup de count com o nome de cnt.
cp count cnt
# 35) Use o cat para criar um arquivo backup de cnt com o nome de catcnt.
cat cnt > catcnt
# 36) Mostre o conteúdo de catcnt, com todas as linhas na ordem inversa.
tac catcnt
# 37) Use o more para exibir o conteúdo do arquivo /var/log/syslog.
more /var/log/syslog
# 38) Use ls para obter o conteúdo do diretório /etc para um arquivo chamado etc.txt.
ls /etc > etc.txt
# 39) Abra dois terminais no mesmo computador. Crie um arquivo vazio chamado tailing.txt. Em seguida, digite o comando “tail -f tailing.txt”. Use o segundo terminal e acrescentar uma linha de texto nesse arquivo. Verifique o que acontece no primeiro terminal.
   #t1
touch tailing.txt
tail -f tailing.txt
   #t2
echo "Nova linha adicionada" >> tailing.txt
# 40) Esse exercício é só para completar 40... :) 