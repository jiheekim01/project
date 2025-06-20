use sakila;
/*
문제 4: 대여되지 않은 영화 목록 찾기
문제
대여되지 않은 영화 조회
해결 방법
대여된 영화와 대여되지 않은 영화 비교:
inventory 테이블과 rental 테이블을 조인하여 대여되지 않은 영화를 찾음
*/

/*
 * 대여되지 않은 영화를 조회하기 위해서 대여 정보가 없는 영화를 찾아야 합니다.
 * 이를 위해서는 film, inventory, rental 테이블을 조인하고,
 * 대여 기록이 없는 영화만 필터링해야 합니다.
 */
select f.title 
from
    film f 
left join inventory i on f.film_id = i.film_id  
left join rental r on i.inventory_id = r.inventory_id  
where r.rental_id is null  
order by f.title;  

commit;
