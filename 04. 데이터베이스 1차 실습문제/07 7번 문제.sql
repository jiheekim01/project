use sakila;
/*
문제 7: 특정 기간 동안 대여된 영화 목록
문제
	 5회 대여된 영화 목록과 대여 건수 조회
해결 방법
기간 조건 추가:
rental_date를 기준으로 특정 기간에 해당하는 대여 데이터를 필터링.
*/
/*
 * rental 데이터와 inventory 데이터를 조인
 * inventory 데이터와 film 데이터를 연결
 * 대여 날짜가 2005년 5월 1일부터 5월 31일까지인 데이터만 선택
 * */
/*
 * 인라인뷰 미사용
 * */
SELECT 
    f.title AS film_title,
    COUNT(r.rental_id) AS rental_count
FROM 
    rental r
    INNER JOIN inventory i ON r.inventory_id = i.inventory_id
    INNER JOIN film f ON i.film_id = f.film_id
where 
	r.rental_date between '2005-05-01' and '2005-05-31'
GROUP BY 
    f.film_id
 having 
 	rental_count = 5
;
/*
 * 인라인 뷰 사용
 */
SELECT 
	f.title AS film_title,
    COUNT(x.rental_id) AS rental_count
from
	film f
	inner join(
		select
		r.rental_id, r.inventory_id ,i.film_id 
		from rental r
		inner join inventory i ON r.inventory_id = i.inventory_id
		where r.rental_date between '2005-05-01' and '2005-05-31'
	) as x
ON x.film_id = f.film_id 
group by
	f.film_id
having 
	rental_count =5;

commit;