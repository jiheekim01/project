use sakila;

/*
 * 문제 2: 특정 배우가 출연한 영화의 매출 기여도 분석
	문제
	특정 배우(예: "TIM HACKMAN")가 출연한 영화가 총 매출에 얼마나 기여했는지 조회
	해결 방법
	배우 ID 조회:
		actor 테이블에서 해당 배우의 ID를 조회.
	영화 목록 조회:
		film_actor와 film 테이블을 연결하여 해당 배우가 출연한 영화 목록을 확인.
	매출 기여도 계산:
		대여와 결제를 연결하여 총 매출 기여도를 계산.
 */

/*
 * 특정 배우의 테이블을 갖고 오기 위해서 actor 테이블이 필요합니다
 * 이때 매출 기여도를 분석하기 위해서 payment 테이블이 필요하는데 
 * actor랑 payment랑 직접적으로 연결을 할 수 없습니다.
 * 그래서 actor 출발하여 film_actor, film, inventroy, rental을 거쳐서 랑 payment로 연결을 진행합니다.
 * 
 * */

SELECT 
    a.first_name,
    a.last_name,
    f.title,
    SUM(p.amount) AS total_revenue
FROM 
	actor a
	INNER JOIN film_actor fa ON fa.actor_id = a.actor_id
	INNER JOIN film f ON f.film_id = fa.film_id
	INNER JOIN inventory i ON f.film_id = i.film_id
	INNER JOIN rental r ON i.inventory_id = r.inventory_id
	INNER JOIN payment p ON p.rental_id = r.rental_id
WHERE fa.actor_id = (SELECT a.actor_id FROM actor a WHERE a.first_name = 'Tim' AND a.last_name = 'Hackman') -- first name이 tim이고 last name이 Hackman일 때의 조건 서브 쿼리
GROUP BY a.first_name, a.last_name, f.film_id, f.title
order by total_revenue desc;

commit;