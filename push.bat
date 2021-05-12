@echo off

set /p comments=please input commit comments:
 
git status
git add .
git commit -m "%comments%"
git push origin master
echo "Finished Push!"
pause