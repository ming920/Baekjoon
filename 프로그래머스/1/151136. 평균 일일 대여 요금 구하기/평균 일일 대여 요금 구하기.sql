SELECT ROUND(AVG(daily_fee)) as AVERAGE_FEE
from car_rental_company_car
WHERE car_type = 'SUV'
