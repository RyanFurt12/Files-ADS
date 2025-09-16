# Sistema de permissões e usuários 
# 1 – Explique o sistema de permissões no Linux.
O sistema de permissões no linux é dividido em 3 tipos de acesso: Leitura (r), Escrita (w) e Execução(x). 
separado em 3 grupos, usuário dono, grupo dono, e outros, assim resultando em algo assim, por exemplo: "-rw-re-r--"
# 2 – Como root, crie os usuários user1, user2 e user3, todos eles com a senha definida para a mesma string do login (exemplo: login: user1, senha: user1). Verifique se os usuários e seus respectivos diretórios home foram criados corretamente (/home/user1, etc).
sudo useradd -m user1
sudo useradd -m user2
sudo useradd -m user3

echo "user1:user1" | sudo chpasswd
echo "user2:user2" | sudo chpasswd
echo "user3:user3" | sudo chpasswd

ls -ld /home/user*
# 3 – Trave a senha do usuário user1 com usermod (pesquise no man!). Tente logar como esse usuário. Destrave a conta com usermod e teste outra vez.
sudo usermod -L user1
su - user1
sudo usermod -U user1
su - user1
# 4 - Verifique a linha que contém user2 em /etc/shadow. Use “passwd -d” para desabilitar a senha do user2. Verifique se a linha que contém user2 em /etc/shadow mudou. Faça um login com o user2.
sudo grep user2 /etc/shadow
sudo passwd -d user2
sudo grep user2 /etc/shadow
su - user2
# 5 - Coloque novamente um password para o user2 e veja a alteração no arquivo /etc/shadow.
sudo passwd user2
sudo grep user2 /etc/shadow
# 6 - Utilize “passwd –l user2” para travar o password do user2. Verifique o que é alterado no /etc/shadow para o user2. Tente fazer um login com o user2.
sudo passwd -l user2
sudo grep user2 /etc/shadow
su - user2
# 7 - Destrave o password do user2 usando o comando passwd (pesquise no man!). Verifique o que é alterado no /etc/shadow para o user2. Tente fazer um login com o user2.
sudo passwd -u user2
sudo grep user2 /etc/shadow
su - user2
# 8 – Crie um grupo chamado users. Adicione os usuários user1 e user2 no grupo users.
sudo groupadd users
sudo usermod -aG users user1
sudo usermod -aG users user2
# 9 – Usando o grep, mostre a linha do arquivo /etc/group que mostra os usuários que participam do grupo users.
grep users /etc/group
# 10 – Remova o user1 do grupo users e verifique novamente a linha que apresenta os usuários do grupo users no arquivo /etc/group. Verifique o que mudou.
sudo gpasswd -d user1 users
grep users /etc/group
# 11 – Como root, crie uma pasta chamada testes no / (início do sistema de arquivos).
sudo mkdir /testes
# 12 – Dê permissão total nesse diretório (chmod 777 /testes).
sudo chmod 777 /testes
# 13 – Como root, crie um arquivo chamado texto dentro do diretório /testes (digite algumas linhas dentro do arquivo, use o cat para isso, como visto na aula passada). Troque o grupo dono desse arquivo para o grupo users e dê permissão de escrita e leitura para quem participa do grupo. Com o user2, tente ler e escrever no arquivo texto. O que aconteceu? Explique. Dica: para testar a leitura no arquivo, use o cat nome_arquivo, e para testar a escrita, use o cat > nome arquivo.
sudo -i
cd /testes
cat > texto

sudo chgrp users texto
sudo chmod 660 texto
exit

# Como user2:
su - user2
cat /testes/texto
cat > /testes/texto
# 14 – Agora, repita o exercício anterior utilizando user1. Explique o que acontece e a razão disso acontecer.
su - user1
cat /testes/texto
cat > /testes/texto
# 15. Explique o que significa um arquivo com permissões rw-rw-r--.
Dono: leitura e escrita, GrupoDono: leitura e escrita, Outros: somente leitura
# 16. Explique o que significa um diretório com permissões rwxrw---x.
Dono: leitura, escrita e execução, GrupoDono: leitura e escrita, Outros: somente execução
# 17. Com chmod, 770 é o mesmo que rwxrwx---?
Sim, chmod 770 = rwxrwx---
# 18. Com chmod, 664 é o mesmo que r-xr-xr-?
Não, chmod 664 == rw-rw-r--
# 19. Com chmod, 400 é o mesmo que --------?
Não, chmod 400 == r--------
# 20. Com chmod, 734 é o mesmo que rwxr-xr-?
Não, chmod 734 == rwx-wxr--
# 21. Qual a representação numérica das permissões rwxrw---x?
chmod 761
# 22. Qual a representação numérica das permissões rwxr----x?
chmod 741
# 23. Qual a representação numérica das permissões rw-r-----?
chmod 640
# 24. É possível ler ou escrever em um arquivo com permissões --------- (chmod 000)? Como? Teste!
Sim, sendo um super usuário é possível interagir com um arquivo sem permissões.

sudo cat <arquivo>

# Permissões – umask, setuid, setgid, sticky bit
# 1 – Apresente o umask do sistema. Qual o valor apresentado? O que esse valor significa?
umask -> 0002
# 2 – Crie uma pasta chamada tstUmask01 no home do seu usuário (/home/login_do_seu_usuário) e apresente as permissões desta com ls -l. Altere o umask do terminal e crie uma outra pasta chamada tstUmask02. Apresente a diferença com ls -l novamente.
# 3 – Explique o setuid.
# 4 – Pesquise na web e apresente um arquivo do sistema que tenha o setuid habilitado. Mostre-o com o ls -l.
# 5 – Explique o setgid.
# 6 – Crie um arquivo no home do seu usuário. Depois, habilite o setuid e setgid neste. Mostre o resultado com ls -l.
# 7 – Explique o sticky bit.
# 8 – Pesquise na web e mostre um diretório do sistema que tenha o sticky bit habilitado. Mostre-o com o ls -l. 

# Comandos administrativos
# 1 - Use top para mostrar os processos em execução na sua máquina.
# 2 - Faça o top ordenar os processos por uso de memória, de modo que os processos que utilizem mais memória apareçam no topo.
# 3 – Restrinja a exibição do top para mostrar apenas os processos de propriedade do seu usuário. Sai do top depois.
# 4 – Crie dois processos usando o cat (comece a criar um arquivo com o cat > arquivo, mas não finalize-o) em dois terminais diferentes. Procure-os na lista de processos executando (use um terceiro terminal e apresente com o top somente os processos do seu usuário). Mate um usando o sinal -9 e o outro usando o sinal -15. O que é retornado na tela do terminais dos processos cat após o uso do kill nos processos?
# 5 – Repita o exercício anterior, mas finalize todos os processos cat com um só comando.
# 6 - Exiba uma lista de todos os processos em execução na máquina com ps exibindo nome de usuário, mostre os processos de todos os usuários, incluindo processos sem terminal.
# 7 - Qual a relação entre o top e o ps?
# 8 – Usando o ps verifique os pids dos processos sendo executados na máquina. Há alguma relação entre seus valores?
# 9 – Como um usuário normal tente matar um processo do root. O que acontece? 