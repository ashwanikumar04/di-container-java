
#!/bin/sh

git config user.email ashwanikumar04@gmail.com

git filter-branch -f --env-filter '
CORRECT_NAME="Ashwani Kumar"
CORRECT_EMAIL="ashwanikumar04@gmail.com"
export GIT_COMMITTER_NAME="$CORRECT_NAME"
export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
export GIT_AUTHOR_NAME="$CORRECT_NAME"
export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
' --tag-name-filter cat -- --branches --tags
