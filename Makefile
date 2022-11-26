
commit=save changes

dinit:
	docker-compose up -d --build

dreinit: ddown dinit

ddown:
	docker-compose down

git-push:
	git add .
	git commit -m "$(commit)"
	git push