
dinit:
	docker-compose up -d --build

dreinit: ddown dinit

ddown:
	docker-compose down

git:
	git add .
	git commit -m "$(COMMIT)"
	git push