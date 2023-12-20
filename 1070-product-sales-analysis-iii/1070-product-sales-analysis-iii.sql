# Write your MySQL query statement below
WITH FirstYearSales AS (
    SELECT
        s.product_id,
        MIN(s.year) AS first_year
    FROM
        Sales s
    GROUP BY
        s.product_id
)

SELECT
    fs.product_id,
    fs.first_year,
    s.quantity,
    s.price
FROM
    FirstYearSales fs
JOIN
    Sales s ON fs.product_id = s.product_id AND fs.first_year = s.year;