SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
UNION
SELECT DISTINCT viewer_id AS id
FROM Views
WHERE viewer_id = author_id
ORDER BY id;