# Stage 1
FROM node:10.15.3-alpine as node

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

# Stage 2
FROM nginx:1.14.2-alpine

COPY --from=node /usr/src/app/dist/front-prueba-tecnica /usr/share/nginx/html

COPY nginx/nginx.conf /etc/nginx/nginx.conf