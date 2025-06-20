use sakila;

/*
문제 6: 특정 카테고리의 대여 트렌드 분석
문제
특정 카테고리(예: "Action"에 대해)의 대여 트렌드를 분석하여 월별 대여 횟수 조회.
해결 방법
카테고리 ID 조회:
category 테이블에서 해당 카테고리 ID를 조회.
월별 대여 횟수 집계:
film_category와 rental을 연결하여 대여 데이터를 분석.
*/
/*
 *  category 테이블에서 해당 카테고리 이름에 맞는 카테고리 ID를 조회하면 됩니다.
    film_category와 rental 테이블을 조인하여 대여 데이터를 월별로 분석하였습니다.
 */


SELECT 
	date_format(r.rental_date,'%Y-%m') as month,
    COUNT(*) AS rental_count
FROM
	rental r
	inner JOIN inventory i ON r.inventory_id = i.inventory_id
	inner JOIN film_category fc ON i.film_id = fc.film_id
WHERE fc.category_id = (SELECT category_id FROM category WHERE name = 'Action')
GROUP BY month
ORDER BY month;

commit;




commit;