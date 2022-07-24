INSERT INTO airports
VALUES (1, 'Gomel', 'Belarus', 'Gomel Airport'),
       (2, 'Minsk', 'Belarus', 'Minsk National Airport'),
       (3, 'Moscow', 'Russia', 'Sheremetyevo');
INSERT INTO planes
VALUES (1, 'ANA Boeing B787-9'),
    (2, 'ANA B737-500'),
    (3, 'Airbus A320neo');
INSERT INTO seats
VALUES (1, 0, 'A1', 'ECONOMY', 1),
    (2, 10, 'D5', 'BUSINESS', 2),
    (3, 0, 'A2', 'ECONOMY', 1);
INSERT INTO flightInfos
VALUES (1, 5000, 100, 1, 2),
       (2, 200, 200, 3, 1),
       (3, 10000, 2300, 1, 2);