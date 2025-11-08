SELECT
  ROUND(
    COUNT(T2.player_id) * 1.0 / 
    COUNT(T1.player_id),
    2
  ) AS fraction
FROM
  (
    SELECT
      player_id,
      MIN(event_date) AS first_login_date
    FROM
      Activity
    GROUP BY
      player_id
  ) AS T1
  LEFT JOIN Activity AS T2 ON T1.player_id = T2.player_id
  AND DATEDIFF(T2.event_date, T1.first_login_date) = 1;