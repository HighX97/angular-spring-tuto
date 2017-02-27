# Define the Application Filters Module
numberFilters = angular.module 'numberFilters', []

# Define the GreetingListController Controller
numberFilters.filter 'base', ->
  someting = (input, base) ->
    parsed = parseInt(input, 10)
    based = parseInt(base, 10)
    #isNaN is not isNan
    if isNaN(parsed) || isNaN(based)
      console.log ("nan")
      input
    parsed.toString(based)
    # 0
