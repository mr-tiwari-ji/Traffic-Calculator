# Traffic-Calculator

The goal:

To create a calculator that helps a user to understand how much potential traffic they could generate for a specific keyword, based on its position in Google search results and then provide an estimated revenue total based on that traffic and their conversion rate.

The click-through rate for each position of Google 1 through 10 has a different percentage.

I would like the tool to ask if they are an e-commerce or service business.

If they select "service based" then there will be an extra input field called "average sales close rate"

Inputs:

Current Position 2 to 100 [manual input]
Target position 1 to 10 [manual input]
Keyword [manual input]
Keyword total search volume [manual input]
Average conversion rate [manual input]
Average order value/customer value [manual input]
E-commerce or Service based? [dropdown]

Position 1 — 20.5%
Position 2 — 13.32%
Position 3 — 13.14%
Position 4 — 8.98%
Position 5 — 9.21%
Position 6 — 6.73%
Position 7 — 7.61%
Position 8 — 6.92%
Position 9 — 5.52%
Position 10 — 7.95%

Example Traffic Estimate (E-Commerce):

Inputs:

E-commerce or Service based = e-commerce
Position = 2 (13.32%)
Keyword = best SEO click-through rate
Keyword Total Search Volume = 2000

Output:
Estimated Traffic = 266.4 (round it down to the nearest whole number)

Example Conversion Estimate:

Inputs:

Website Conversion Rate = 2.35%
Value of conversion (average order/customer value) = £200
If "Service Based" - Close rate = 15%

E-commerce Output:
E-commerce - Total conversions from "Estimated Traffic" x Conversion value (6.2 x £200) = £1240

Example Traffic Estimate (Service-Based):

Inputs:

E-commerce or Service based = service-based
Position = 2 (13.32%)
Keyword = best SEO click-through rate
Keyword Total Search Volume = 2000
Sales Close Rate Percentage = 22

Output:
Estimated Traffic = 266.4 (round it down to the nearest whole number)

Example Conversion Estimate:

Inputs:

Website Conversion Rate = 2.35%
Value of conversion (average order/customer value) = £5000
Sales Close rate = 22%

Service-Based Output:
Service Based - "Close rate percentage" of "Total conversions" from "Estimated Traffic" x Conversion value = £6800

End Result:

The end result would be the calculator stating that if your site was in Position 2 for the keyword "best SEO click-through rate" you would make £1240 per month on average.

I would want it to include validation and potentially output a graph like the one attached that includes CTR, revenue potential and estimated traffic.

Ideally, the graph would be sharable so that users could easily do a calculation and share the result in a visual way with a link back to the tool.
