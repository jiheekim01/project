use sakila;

/*
문제 5: 고객의 활동성 분석
- 고객의 대여 횟수와 평균 결제 금액을 기반으로 상위 5명의 VIP 고객을 식별하고 조회
- rental과 payment 테이블을 조인하여 고객별 데이터를 집계하고, 대여 횟수와 결제 금액을 계산
*/

/*
 * 고객의 활동성을 분석하기 위해 rental과 payment 테이블을 사용하여,
 * 고객별 대여 횟수와 평균 결제 금액을 계산합니다.
 * 대여 횟수와 결제 금액을 기준으로 상위 5명의 고객을 조회합니다.
 */
SELECT
    c.customer_id,  
    concat(c.first_name, " ", c.last_name ) as customer_name,  
    COUNT(r.rental_id) AS rental_count,  
    AVG(p.amount) AS avg_payment_amount  
FROM
    rental r  
left JOIN payment p ON
    p.rental_id = r.rental_id  
left JOIN customer c on
    c.customer_id = r.customer_id  
GROUP BY
    c.customer_id, 
    c.first_name, c.last_name   
ORDER BY
    rental_count DESC, 
    avg_payment_amount DESC  
LIMIT 5;  

commit;
